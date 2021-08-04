package com.example.mtap.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.mtap.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HeadLines.newInstance] factory method to
 * create an instance of this fragment.
 */
class HeadLines : Fragment(), AdapterView.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listview: ListView
    lateinit var onHeadLineClick: OnHeadLineClick

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
        onHeadLineClick = activity as OnHeadLineClick //wiring
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view:View =inflater.inflate(R.layout.fragment_head_lines, container, false)
        listview = view.findViewById(R.id.lvHeadlines)
        listview.onItemClickListener = this
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HeadLines.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HeadLines().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onItemClick(adapterView: AdapterView<*>?, row: View?, position: Int, rowId: Long) {
        Toast.makeText(activity, adapterView?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        onHeadLineClick.onHeadClick(adapterView?.getItemAtPosition(position).toString())
    }

    interface OnHeadLineClick {
        fun onHeadClick(headline: String)
    }
}


