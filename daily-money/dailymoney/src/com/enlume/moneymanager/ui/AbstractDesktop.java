package com.enlume.moneymanager.ui;

import android.app.Activity;

import com.enlume.commons.util.I18N;
import com.enlume.moneymanager.context.Contexts;
/**
 * 
 *
 */
public abstract class AbstractDesktop extends Desktop {
    protected I18N i18n;
    public AbstractDesktop(Activity activity) {
        super(activity);
        i18n = Contexts.instance().getI18n();
        init();
    }
    abstract protected void init();
}
