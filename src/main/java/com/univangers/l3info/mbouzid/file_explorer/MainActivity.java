package com.univangers.l3info.mbouzid.fileexplorer;

import android.app.ListActivity;
import android.os.Bundle;
import FileAdapter;

public class MainActivity extends ListActivity
{

  private FileAdapter m_adapter;
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  /**
  *  Start activity.
  *  @method protected
  *  @param {Bundle} savedInstanceState
  */
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    m_adapter=new FileAdapter(this,Environment.getExternalStorageDirectory().listFiles());
    setListAdapter(m_adapter);
  }

  @Override
  public void onListItemClick(ListView parent, View v, int pos, long id)
  /**
  * Called when an item is clicked.
  * @method public
  * @param {ListView} parent
  * @param {View} v
  * @param {int} pos
  * @param {long} id
  */
  {
    TextView current_directory = (TextView) findViewById(R.id.m_current_directory);
    current_directory.setText(m_adapter.getItem(pos).getName());
  }



}
