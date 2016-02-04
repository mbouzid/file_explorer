package com.univangers.l3info.mbouzid.fileexplorer;

import android.app.ListActivity;
import android.widget.TextView;
import android.view.View;
import android.widget.ListView;
import android.os.Bundle;
import FileAdapter;
import android.os.Environment;

public class MainActivity extends ListActivity
{

  private FileAdapter m_adapter;
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    m_adapter=new FileAdapter(this,Environment.getExternalStorageDirectory().listFiles());
    setListAdapter(m_adapter);
  }

  @Override
  public void onListItemClick(ListView parent, View v, int pos, long id)
  {
    TextView current_directory = (TextView) findViewById(R.id.m_current_directory);
    current_directory.setText(m_adapter.getItem(pos).getName());
  }



}
