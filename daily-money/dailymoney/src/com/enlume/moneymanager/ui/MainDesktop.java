package com.enlume.moneymanager.ui;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;

import com.enlume.moneymanager.R;
import com.enlume.moneymanager.data.Detail;
/**
 * 
 *
 */
public class MainDesktop extends AbstractDesktop {

    public MainDesktop(Activity activity) {
        super(activity);
    }

    @Override
    protected void init() {
        label = i18n.string(R.string.dt_main);
        icon = R.drawable.home;

        DesktopItem adddetdt = new DesktopItem(new Runnable() {
            public void run() {
                Detail d = new Detail("", "", new Date(), 0D, "");
                Intent intent = null;
                intent = new Intent(activity,DetailEditorActivity.class);
                intent.putExtra(DetailEditorActivity.INTENT_MODE_CREATE,true);
                intent.putExtra(DetailEditorActivity.INTENT_DETAIL,d);
                activity.startActivityForResult(intent,Constants.REQUEST_DETAIL_EDITOR_CODE);
            }
        }, i18n.string(R.string.dtitem_adddetail), R.drawable.add,999);

        Intent intent = new Intent(activity, DetailListActivity.class);
        intent.putExtra(DetailListActivity.INTENT_MODE, DetailListActivity.MODE_DAY);
        DesktopItem daylist = new DesktopItem(new IntentRun(activity, intent),
                i18n.string(R.string.dtitem_detlist_day), R.drawable.dtitem_detail_day);
        
        intent = new Intent(activity, DetailListActivity.class);
        intent.putExtra(DetailListActivity.INTENT_MODE, DetailListActivity.MODE_WEEK);
        DesktopItem weeklist = new DesktopItem(new IntentRun(activity, intent),
                i18n.string(R.string.dtitem_detlist_week), R.drawable.dtitem_detail_week);

        intent = new Intent(activity, DetailListActivity.class);
        intent.putExtra(DetailListActivity.INTENT_MODE, DetailListActivity.MODE_MONTH);
        DesktopItem monthlist = new DesktopItem(new IntentRun(activity, intent),
                i18n.string(R.string.dtitem_detlist_month), R.drawable.dtitem_detail_month);

        intent = new Intent(activity, DetailListActivity.class);
        intent.putExtra(DetailListActivity.INTENT_MODE, DetailListActivity.MODE_YEAR);
        DesktopItem yearlist = new DesktopItem(new IntentRun(activity, intent),
                i18n.string(R.string.dtitem_detlist_year), R.drawable.dtitem_detail_year);

        
        addItem(adddetdt);
        addItem(daylist);
        addItem(weeklist);
        addItem(monthlist);
        addItem(yearlist);
       
    }

}
