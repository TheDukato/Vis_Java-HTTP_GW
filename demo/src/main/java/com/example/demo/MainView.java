package com.example.demo;



import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
//import org.apache.catalina.webresources.FileResource;
//import org.codehaus.commons.compiler.util.resource.FileResource;


import java.io.File;


@Route("/")
public class MainView extends VerticalLayout {
    private HorizontalLayout centerLayout = new HorizontalLayout();
    private HorizontalLayout HeaderLayout = new HorizontalLayout();
    private VerticalLayout consumptionChartLayout;
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
    }
    private void openLocalization (ClickEvent event) {
        header.setText("Localization");
        BodyLayout.removeAll();
    }
}
