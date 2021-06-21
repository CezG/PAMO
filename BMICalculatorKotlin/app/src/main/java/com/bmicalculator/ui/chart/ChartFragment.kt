package com.bmicalculator.ui.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bmicalculator.R

class ChartFragment : Fragment() {
    private var chartViewModel: ChartViewModel? = null
    private var webViewChart: WebView? = null
    private val chartUrl = "https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&time=2020-03-01..latest&pickerSort=desc&pickerMetric=total_cases&hideControls=true&Metric=Confirmed+cases&Interval=7-day+rolling+average&Relative+to+Population=false&Align+outbreaks=false&country=~POL"
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        chartViewModel = ViewModelProvider(this).get(ChartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_chart, container, false)
        webViewChart = root.findViewById<View>(R.id.webViewChart) as WebView
        webViewChart!!.settings.javaScriptEnabled = true
        webViewChart!!.loadUrl(chartUrl)
        //        String unencodedHtml ="&lt;html&gt;&lt;body&gt;'%23' is the percent code for ‘#‘ &lt;/body&gt;&lt;/html&gt;";
//        String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(), Base64.NO_PADDING);
//        webViewChart.loadData(encodedHtml,"text/html","base64");
        chartViewModel!!.text.observe(viewLifecycleOwner, {
            //                webViewChart
        })
        return root
    }
}