package com.example.multiplescreen.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.multiplescreen.R
import com.example.multiplescreen.adapter.MyAdapter
import com.example.multiplescreen.model.Player
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ListFragment : Fragment(), ListContract.View {

    lateinit var presenter: ListPresenter
    var player : MutableList<Player> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // sampein datanya dari adapter
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = MyAdapter(context, player)

        presenter.getData(player)
    }

    private fun initPresenter() {
        presenter = ListPresenter(context, player)
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }
}
