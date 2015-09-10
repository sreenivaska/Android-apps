package com.enlume.moneymanager.ui;

import android.app.Activity;
import android.content.Intent;

import com.enlume.moneymanager.R;
import com.enlume.moneymanager.ui.report.BalanceActivity;
/**
 * 
 *
 */
public class ReportsDesktop extends AbstractDesktop {

    public ReportsDesktop(Activity activity) {
        super(activity);
    }

    @Override
    protected void init() {
        label = i18n.string(R.string.dt_reports);
        icon = R.drawable.report;
        
        Intent intent = null;
        
        intent = new Intent(activity, BalanceActivity.class);
        intent.putExtra(BalanceActivity.INTENT_TOTAL_MODE, false);
        intent.putExtra(BalanceActivity.INTENT_MODE, BalanceActivity.MODE_MONTH);
        DesktopItem monthBalance = new DesktopItem(new IntentRun(activity, intent),
                i18n.string(R.string.dtitem_report_monthly_balance), R.drawable.dtitem_balance_month);
        addItem(monthBalance);
        
        intent = new Intent(activity, BalanceActivity.class);
        intent.putExtra(BalanceActivity.INTENT_TOTAL_MODE, false);
        intent.putExtra(BalanceActivity.INTENT_MODE, BalanceActivity.MODE_YEAR);
        DesktopItem yearBalance = new DesktopItem(new IntentRun(activity, intent),
                i18n.string(R.string.dtitem_report_yearly_balance), R.drawable.dtitem_balance_year);
        addItem(yearBalance);
        
        intent = new Intent(activity, BalanceActivity.class);
        intent.putExtra(BalanceActivity.INTENT_TOTAL_MODE, true);
        intent.putExtra(BalanceActivity.INTENT_MODE, BalanceActivity.MODE_MONTH);
        DesktopItem totalBalance = new DesktopItem(new IntentRun(activity, intent),
                i18n.string(R.string.dtitem_report_cumulative_balance), R.drawable.dtitem_balance_cumulative_month,99);
        addItem(totalBalance);
    }

}
