package com.example.demo;



import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import jdk.dynalink.linker.LinkerServices;
//import org.apache.catalina.webresources.FileResource;
//import org.codehaus.commons.compiler.util.resource.FileResource;


import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.vaadin.flow.component.Tag.H5;


@Route("/")
public class MainView extends VerticalLayout {
    private HorizontalLayout centerLayout = new HorizontalLayout();
    private HorizontalLayout HeaderLayout = new HorizontalLayout();
    private VerticalLayout consumptionChartLayout;
    private VerticalLayout envMeansurmentChartLayout;
    private VerticalLayout BodyLayout = new VerticalLayout();
    private H1 header = new H1("Header-Title");;

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
        var sidebutton1 = new Button("Consumption",this::openConsumption);
        var sidebutton2 = new Button("Enviroment_Meansurment",this::openEnviromentMeansurment);
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
        HorizontalLayout buttonEnviromentMeansurment = new HorizontalLayout();
        envMeansurmentChartLayout = new VerticalLayout();
        envMeansurmentChartLayout.add(new H1("Chart Layout-Enviroment Meansurment"));



        buttonEnviromentMeansurment.add(new Button("Get temp from 1 position",this::openPos1));
        buttonEnviromentMeansurment.add(new Button("Get temp from 2 position",this::openPos2));
        buttonEnviromentMeansurment.add(new Button("Get temp from 3 position",this::openPos3));
        envMeansurmentChartLayout.add(buttonEnviromentMeansurment);
        //envMeansurmentChartLayout.getStyle().set("background","url(https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/800px-Flag_of_Argentina.svg.png)");
        envMeansurmentChartLayout.getStyle().set("background","url(D:\\Kamil\\.Studia\\Praca_Inz\\REPO\\Vis_Java-HTTP_GW\\demo\\ExampleFigure.png)");

        Measurement Sample;
        Sample =  DB_API.getLastDataFromDB(1,"'2022-10-01 17:09:52'");
        envMeansurmentChartLayout.add(new H4("Temperature at " + Sample.getTimestampOf()+" is equal to: "+Sample.getValue() +" in location: "+ Sample.getId_location()+"\t\n"));
        Sample =  DB_API.getLastDataFromDB(2,"'2022-10-01 17:09:52'");
        envMeansurmentChartLayout.add(new H4("Temperature at " + Sample.getTimestampOf()+" is equal to: "+Sample.getValue() +" in location: "+ Sample.getId_location()+"\t\n"));
        Sample =  DB_API.getLastDataFromDB(3,"'2022-10-01 17:09:52'");
        envMeansurmentChartLayout.add(new H4("Temperature at " + Sample.getTimestampOf()+" is equal to: "+Sample.getValue() +" in location: "+ Sample.getId_location()+"\t\n"));

        BodyLayout.add(envMeansurmentChartLayout);
    }
    private void openPos1 (ClickEvent event) {
        header.setText("EnviromentMeansurment- Temperature 1");
        BodyLayout.removeAll();
        List<Measurement> listOfSample = new ArrayList<Measurement>();
        listOfSample =  DB_API.getDataFromDB(1,"'2022-10-01 17:09:52'");
        for (Measurement mes: listOfSample){
            BodyLayout.add(new H4("Temperature at " + mes.getTimestampOf()+" is equal to: "+mes.getValue() + "\n"));
        }
    }
    private void openPos2 (ClickEvent event) {
        header.setText("EnviromentMeansurment - Temperature 2");
        BodyLayout.removeAll();
        List<Measurement> listOfSample = new ArrayList<Measurement>();
        listOfSample =  DB_API.getDataFromDB(2,"'2022-10-01 17:09:52'");
        for (Measurement mes: listOfSample){
            BodyLayout.add(new H4("Temperature at " + mes.getTimestampOf()+" is equal to: "+mes.getValue() + "\n"));
        }
    }
    private void openPos3 (ClickEvent event) {
        header.setText("EnviromentMeansurment - Temperature 3");
        BodyLayout.removeAll();
        List<Measurement> listOfSample = new ArrayList<Measurement>();
        listOfSample =  DB_API.getDataFromDB(3,"'2022-10-01 17:09:52'");
        for (Measurement mes: listOfSample){
            BodyLayout.add(new H4("Temperature at " + mes.getTimestampOf()+" is equal to: "+mes.getValue() + "\n"));
        }
    }
    private void openLocalization (ClickEvent event) {
        header.setText("Localization");
        BodyLayout.removeAll();
    }
}
