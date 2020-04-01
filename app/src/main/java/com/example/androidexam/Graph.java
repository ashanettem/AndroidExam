package com.example.androidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Graph extends AppCompatActivity {

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    BarChart barChart;

    Float aPercent, bPercent, cPercent, dPercent, fPercent;
    Float that;

    Description description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        sharedPref = getSharedPreferences("Percentages", MODE_PRIVATE);
        editor = sharedPref.edit();

        barChart = (BarChart)findViewById(R.id.barGraph);



        //(sharedPref.getFloat("a%", 0))

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, (sharedPref.getFloat("a%", 0)), 0));
        barEntries.add(new BarEntry(2, (sharedPref.getFloat("b%", 0)), 1));
        barEntries.add(new BarEntry(3, (sharedPref.getFloat("c%", 0)), 2));
        barEntries.add(new BarEntry(4, (sharedPref.getFloat("d%", 0)), 3));
        barEntries.add(new BarEntry(5, (sharedPref.getFloat("f%", 0)), 4));
        BarDataSet barDataSet = new BarDataSet(barEntries, "% of Students");

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


        final String[] percentages = {"", " A% ", "B%", " C% ", " D% ", " F% "};

        final ArrayList<String> percentagesLabel = new ArrayList<>();
        percentagesLabel.add("A%");
        percentagesLabel.add("B%");
        percentagesLabel.add("C%");
        percentagesLabel.add("D%");
        percentagesLabel.add("F%");




        BarData theData = new BarData(barDataSet);
        theData.setBarWidth(.75f);


        barChart.setData(theData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setDrawValueAboveBar(true);
        barChart.setFitBars(true);
        barChart.getDescription().setText("");

        //barChart.setDescription();


        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(percentages));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.isCenterAxisLabelsEnabled();
        xAxis.setDrawGridLines(false);


    }
}
