/*
 * Ad Free
 * Copyright (c) 2017 by abertschi, www.abertschi.ch
 * See the file "LICENSE" for the full license governing this code.
 */

package ch.abertschi.adfree.view.setting

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ch.abertschi.adfree.BuildConfig
import ch.abertschi.adfree.R
import ch.abertschi.adfree.view.ViewSettings
import org.jetbrains.anko.onClick

/**
 * Created by abertschi on 21.04.17.
 */

class AboutActivity : Fragment() {

    lateinit var mTypeFace: Typeface

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.about_view, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTypeFace = ViewSettings.instance(this.context).typeFace

        val textView = view?.findViewById(R.id.authorTitle) as TextView
        textView.typeface = mTypeFace
        val text =
        "built with much &lt;3 by <font color=#FFFFFF>abertschi</font>. get my latest hacks and follow me on twitter."

        textView?.text = Html.fromHtml(text)

        val versionView = view?.findViewById(R.id.version) as TextView
        versionView?.typeface = mTypeFace
        versionView?.text = "v${BuildConfig.VERSION_NAME} / ${BuildConfig.VERSION_CODE}"

        view?.findViewById(R.id.twitter).onClick {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/andrinbertschi"))
            this.getContext().startActivity(browserIntent)
        }

        view?.findViewById(R.id.website).onClick {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://abertschi.ch"))
            this.getContext().startActivity(browserIntent)
        }
    }
}