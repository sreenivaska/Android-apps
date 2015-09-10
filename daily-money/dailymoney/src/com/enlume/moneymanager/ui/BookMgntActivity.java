package com.enlume.moneymanager.ui;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;

import com.enlume.moneymanager.R;
import com.enlume.commons.util.GUIs;
import com.enlume.moneymanager.context.ContextsActivity;
import com.enlume.moneymanager.data.Book;
import com.enlume.moneymanager.data.IMasterDataProvider;

/**
 * 
 * 
 */
public class BookMgntActivity extends ContextsActivity {
    
    BookListHelper bookListHelper;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmgnt);
        initialIntent();
        initialContent();
        GUIs.delayPost(new Runnable() {
            @Override
            public void run() {
                reloadData();
            }
        },25);
    }
    

    private void initialIntent() {

    }


    private void initialContent() {
        
        
        bookListHelper = new BookListHelper(this, i18n,true, new BookListHelper.OnBookListener() {
            @Override
            public void onBookDeleted(Book book) {
                GUIs.shortToast(BookMgntActivity.this, i18n.string(R.string.msg_book_deleted,book.getName()));
                reloadData();
            }
        });
        
        ListView listView = (ListView)findViewById(R.id.bookmgnt_list);
        bookListHelper.setup(listView);
        
        registerForContextMenu(listView);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.REQUEST_BOOK_EDITOR_CODE && resultCode==Activity.RESULT_OK){
            GUIs.delayPost(new Runnable(){
                @Override
                public void run() {
                    reloadData();
                }});
        }
    }


    private void reloadData() {
        final IMasterDataProvider idp = getContexts().getMasterDataProvider();
        GUIs.doBusy(this,new GUIs.BusyAdapter() {
            List<Book> data = null;
            
            @Override
            public void run() {
                data = idp.listAllBook();
            }
            @Override
            public void onBusyFinish() {
              //update data
                bookListHelper.reloadData(data);
            }
        });
        
        
    }
    
   
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.bookmgnt_list) {
            getMenuInflater().inflate(R.menu.bookmgnt_ctxmenu, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == R.id.bookmgnt_menu_edit) {
            bookListHelper.doEditBook(info.position);
            return true;
        } else if (item.getItemId() == R.id.bookmgnt_menu_delete) {
            bookListHelper.doDeleteBook(info.position);
            return true;
        } else if (item.getItemId() == R.id.bookmgnt_menu_set_working) {
            bookListHelper.doSetWorkingBook(info.position);
            finish();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
