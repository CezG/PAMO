package com.bmicalculator.ui.chart;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.DocumentsContract;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.bmicalculator.R;
import com.bmicalculator.ui.home.HomeViewModel;

import org.w3c.dom.Document;

public class ChartFragment extends Fragment {

    private ChartViewModel chartViewModel;
    private WebView webViewChart;
    private String chartUrl = "https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&time=2020-03-01..latest&pickerSort=desc&pickerMetric=total_cases&hideControls=true&Metric=Confirmed+cases&Interval=7-day+rolling+average&Relative+to+Population=false&Align+outbreaks=false&country=~POL";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chartViewModel =
                new ViewModelProvider(this).get(ChartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chart, container, false);
        webViewChart = (WebView) root.findViewById(R.id.webViewChart);
        webViewChart.getSettings().setJavaScriptEnabled(true);
        webViewChart.loadUrl(chartUrl);
//        String unencodedHtml ="&lt;html&gt;&lt;body&gt;'%23' is the percent code for ‘#‘ &lt;/body&gt;&lt;/html&gt;";
//        String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(), Base64.NO_PADDING);
//        webViewChart.loadData(encodedHtml,"text/html","base64");
        chartViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                webViewChart
            }
        });
        return root;
    }

}