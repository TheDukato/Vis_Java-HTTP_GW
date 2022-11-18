package com.example.demo;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;




@Route("/")
public class MainView extends VerticalLayout {
    private HorizontalLayout centerLayout = new HorizontalLayout();
    private HorizontalLayout HeaderLayout = new HorizontalLayout();
    private VerticalLayout BodyLayout = new VerticalLayout();
    private VerticalLayout consumptionChartLayout;
    private VerticalLayout envMeansurmentChartLayout;
    private H1 header = new H1("Header-Title");;
    private HorizontalLayout buttonEnviromentMeansurment = new HorizontalLayout();


    public MainView() {
/*      var button = new Button("Click me");
        var textField = new TextField("Hello desr");
        add(new H1("Hello world!!!!"));
        Chart chart = new Chart(ChartType.COLUMN);
        plots_2D plot = new plots_2D();
        add(new HorizontalLayout(button,textField,chart));
*/
        var sideLayout = new VerticalLayout();
        var buttonGroup = new VerticalLayout();

        buttonEnviromentMeansurment.add(new Button("Get chart of temp from 1 position",this::openPos1));
        buttonEnviromentMeansurment.add(new Button("Get chart of temp from 2 position",this::openPos2));
        buttonEnviromentMeansurment.add(new Button("Get chart of temp from 3 position",this::openPos3));

        //BodyLayout.setWidth(80, Unit.PERCENTAGE);
        //BodyLayout.setHeight(90, Unit.PERCENTAGE);

        var sidebutton1 = new Button("Consumption",this::openConsumption);
        var sidebutton2 = new Button("Enviroment Meansurment",this::openEnviromentMeansurment);
        var sidebutton3 = new Button("Localization",this::openLocalization);
        buttonGroup.add(sidebutton1);
        buttonGroup.add(sidebutton2);
        buttonGroup.add(sidebutton3);
        sideLayout.add(buttonGroup);
        //sideLayout.setHorizontalComponentAlignment(Alignment.CENTER, buttonGroup);

        BodyLayout.add(new H1("Body"));

        HeaderLayout.add(header);
        centerLayout.add(sideLayout,BodyLayout);
        this.add(HeaderLayout,centerLayout);
    }
    private void openConsumption (ClickEvent event) {
        header.setText("Consumption");
        BodyLayout.removeAll();
        HorizontalLayout buttonConsumption = new HorizontalLayout();
        consumptionChartLayout = new VerticalLayout(new H1("Chart Layout Blank"));

        buttonConsumption.add(new Button("Electricity",this::openConsumptionE));
        buttonConsumption.add(new Button("Water",this::openConsumptionW));
        buttonConsumption.add(new Button("Gas",this::openConsumptionG));
        buttonConsumption.add(new Button("Heat",this::openConsumptionH));
        buttonConsumption.add(new Button("Internet",this::openConsumptionI));

        BodyLayout.add(buttonConsumption,consumptionChartLayout);
    }
    private void openConsumptionE (ClickEvent event) {
        header.setText("Consumption-Electricity");
        consumptionChartLayout.removeAll();
        consumptionChartLayout.add(new H1("Chart Layout-Electricity"));
  /*      List<Measurement> listOfSample = new ArrayList<Measurement>();
        listOfSample =  DB_API.getDataFromDB(3,"2022-10-01");
        for (Measurement mes: listOfSample){
            System.out.println(mes.getTimestampOf()+"_ _"+mes.getValue());
        }
        //plots_2D temp = new plots_2D();
        //temp.mes = listOfSample;
        //consumptionChartLayout.add((Collection<Component>) temp);*/
    }
    private void openConsumptionW (ClickEvent event) {
        header.setText("Consumption-Water");
        consumptionChartLayout.removeAll();
        consumptionChartLayout.add(new H1("Chart Layout-Water"));
        //FileResource resource = new FileResource(new File("D:/Kamil/.Studia/Praca_Inz/Praktyka/Front-End/demo"));
    }
    private void openConsumptionG (ClickEvent event) {
        header.setText("Consumption-Gas");
        consumptionChartLayout.removeAll();
        consumptionChartLayout.add(new H1("Chart Layout-Gas"));
    }
    private void openConsumptionH (ClickEvent event) {
        header.setText("Consumption-Heat");
        consumptionChartLayout.removeAll();
        consumptionChartLayout.add(new H1("Chart Layout-Heat"));
    }
    private void openConsumptionI (ClickEvent event) {
        header.setText("Consumption-Internet");
        consumptionChartLayout.removeAll();
        consumptionChartLayout.add(new H1("Chart Layout-Internet"));
    }
    private void openEnviromentMeansurment (ClickEvent event) {
        header.setText("EnviromentMeansurment");
        BodyLayout.removeAll();

        envMeansurmentChartLayout = new VerticalLayout();
        //envMeansurmentChartLayout.add(new H1("Chart Layout-Enviroment Meansurment"));


        envMeansurmentChartLayout.add(buttonEnviromentMeansurment);



        Chart chart = new Chart();
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Temperature comparision in last 30 days");
        conf.setSubTitle("Kills Grouped by Counties");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String ONE_MOTH_DATE_AGO = now.getYear()+"-"+ (now.getMonthValue() - 1) +"-"+now.getDayOfMonth()+" 01:00:00";

        DataSeries series1 = new DataSeries();
        DataSeries series2 = new DataSeries();
        DataSeries series3 = new DataSeries();
        PlotOptionsLine options1 = new PlotOptionsLine();
        XAxis xaxis = new XAxis();
        series1.setPlotOptions(options1);
        series2.setPlotOptions(options1);
        series3.setPlotOptions(options1);
        xaxis.setTitle("Planet");
        List<Measurement> myData1 = new ArrayList<>();
        List<String> myCategories = new ArrayList<>();
        List<DataSeriesItem> mySeries1 = new ArrayList<>();
        //myData1 = DB_API.getDataFromDB(1,"'2022-10-01 17:09:52'");
        myData1 = DB_API.getDataFromDB(1,"'"+ONE_MOTH_DATE_AGO+"'");
        int counter = 1;
        for(Measurement mySample: myData1) {
            myCategories.add(mySample.getTimestampOf());
            mySeries1.add(new DataSeriesItem(counter,Double.parseDouble(mySample.getValue())));
            counter++;
        }
        //////////////
        List<Measurement> myData2 = new ArrayList<>();
        List<DataSeriesItem> mySeries2 = new ArrayList<>();
        //myData2 = DB_API.getDataFromDB(2,"'2022-10-01 17:09:52'");
        myData2 = DB_API.getDataFromDB(2,"'"+ONE_MOTH_DATE_AGO+"'");
        counter = 1;
        for(Measurement mySample: myData2) {
            myCategories.add(mySample.getTimestampOf());
            mySeries2.add(new DataSeriesItem(counter,Double.parseDouble(mySample.getValue())));
            counter++;
        }
        //////////////////
        List<Measurement> myData3 = new ArrayList<>();
        List<DataSeriesItem> mySeries3 = new ArrayList<>();
        myData3 = DB_API.getDataFromDB(3,"'"+ONE_MOTH_DATE_AGO+"'");
        //myData3 = DB_API.getDataFromDB(3,"'2022-10-01 17:09:52'");
        counter = 1;
        for(Measurement mySample: myData3) {
            myCategories.add(mySample.getTimestampOf());
            mySeries3.add(new DataSeriesItem(counter,Double.parseDouble(mySample.getValue())));
            counter++;
        }

        series1.setData(mySeries1);
        series2.setData(mySeries2);
        series3.setData(mySeries3);
        xaxis.setCategories(String.valueOf(myCategories));
        conf.addSeries(series1);
        conf.addSeries(series2);
        conf.addSeries(series3);
        conf.addxAxis(xaxis);
        chart.getConfiguration().getChart().setType(ChartType.LINE);

        //Measurement Sample;
        //Sample =  DB_API.getLastDataFromDB(1);
        //envMeansurmentChartLayout.add(new H4("Temperature at " + Sample.getTimestampOf()+" is equal to: "+Sample.getValue() +" in location: "+ Sample.getId_location()+"\t\n"));
        //Sample =  DB_API.getLastDataFromDB(2);
        //envMeansurmentChartLayout.add(new H4("Temperature at " + Sample.getTimestampOf()+" is equal to: "+Sample.getValue() +" in location: "+ Sample.getId_location()+"\t\n"));
        //Sample =  DB_API.getLastDataFromDB(3);
        //envMeansurmentChartLayout.add(new H4("Temperature at " + Sample.getTimestampOf()+" is equal to: "+Sample.getValue() +" in location: "+ Sample.getId_location()+"\t\n"));

        BodyLayout.add(envMeansurmentChartLayout,chart);
    }
    private void openPos1 (ClickEvent event) {
        header.setText("EnviromentMeansurment- Temperature 1");
        BodyLayout.removeAll();
/*        List<Measurement> listOfSample = new ArrayList<Measurement>();
        listOfSample =  DB_API.getDataFromDB(1,"'2022-10-01 17:09:52'");
        for (Measurement mes: listOfSample){
            BodyLayout.add(new H4("Temperature at " + mes.getTimestampOf()+" is equal to: "+mes.getValue() + "\n"));
        }*/
        Chart chart = new Chart();
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Temperature in last 30 days");
        DataSeries series1 = new DataSeries();
        PlotOptionsLine options1 = new PlotOptionsLine();
        XAxis xaxis = new XAxis();
        series1.setPlotOptions(options1);
        List<Measurement> myData = new ArrayList<>();
        List<String> myCategories = new ArrayList<>();
        List<DataSeriesItem> mySeries = new ArrayList<>();
        myData = DB_API.getDataFromDB(1,"'2022-10-01 17:09:52'");
        int counter = 1;
        for(Measurement mySample: myData) {
            myCategories.add(mySample.getTimestampOf());
            mySeries.add(new DataSeriesItem(counter,Double.parseDouble(mySample.getValue())));
            counter++;
        }

        series1.setData(mySeries);
        xaxis.setCategories(String.valueOf(myCategories));
        conf.addSeries(series1);
        conf.addxAxis(xaxis);
        chart.getConfiguration().getChart().setType(ChartType.LINE);
        BodyLayout.add(envMeansurmentChartLayout,chart);
    }
    private void openPos2 (ClickEvent event) {
        header.setText("EnviromentMeansurment - Temperature 2");
        BodyLayout.removeAll();

        Chart chart = new Chart();
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Temperature comparision in last 30 days");
        DataSeries series1 = new DataSeries();
        PlotOptionsLine options1 = new PlotOptionsLine();
        XAxis xaxis = new XAxis();
        series1.setPlotOptions(options1);
        xaxis.setTitle("Planet");
        List<Measurement> myData = new ArrayList<>();
        List<String> myCategories = new ArrayList<>();
        List<DataSeriesItem> mySeries = new ArrayList<>();
        myData = DB_API.getDataFromDB(2,"'2022-10-01 17:09:52'");
        int counter = 1;
        for(Measurement mySample: myData) {
            myCategories.add(mySample.getTimestampOf());
            mySeries.add(new DataSeriesItem(counter,Double.parseDouble(mySample.getValue())));
            counter++;
        }

        series1.setData(mySeries);
        xaxis.setCategories(String.valueOf(myCategories));
        conf.addSeries(series1);
        conf.addxAxis(xaxis);
        chart.getConfiguration().getChart().setType(ChartType.LINE);
        BodyLayout.add(envMeansurmentChartLayout,chart);
    }
    private void openPos3 (ClickEvent event) {
        header.setText("EnviromentMeansurment - Temperature 3");
        BodyLayout.removeAll();

        Chart chart = new Chart();
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Temperature comparision in last 30 days");
        DataSeries series1 = new DataSeries();
        PlotOptionsLine options1 = new PlotOptionsLine();
        XAxis xaxis = new XAxis();
        series1.setPlotOptions(options1);
        List<Measurement> myData = new ArrayList<>();
        List<String> myCategories = new ArrayList<>();
        List<DataSeriesItem> mySeries = new ArrayList<>();
        myData = DB_API.getDataFromDB(3,"'2022-10-01 17:09:52'");
        int counter = 1;
        for(Measurement mySample: myData) {
            myCategories.add(mySample.getTimestampOf());
            mySeries.add(new DataSeriesItem(counter,Double.parseDouble(mySample.getValue())));
            counter++;
        }

        series1.setData(mySeries);
        xaxis.setCategories(String.valueOf(myCategories));
        conf.addSeries(series1);
        conf.addxAxis(xaxis);
        chart.getConfiguration().getChart().setType(ChartType.LINE);
        BodyLayout.add(envMeansurmentChartLayout,chart);
    }
    private void openLocalization (ClickEvent event) {
        header.setText("Localization");
        BodyLayout.removeAll();
    }
}
