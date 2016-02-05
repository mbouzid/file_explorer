package com.univangers.l3info.mbouzid.fileexplorer;

import android.app.ListActivity;
import android.widget.TextView;
import android.view.View;
import android.widget.ListView;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity
{

  private FileAdapter m_adapter;
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    m_adapter=new FileAdapter(this,Environment.getExternalStorageDirectory());
    setListAdapter(m_adapter);
  }

  @Override
  public void onListItemClick(ListView parent, View v, int pos, long id)
  {
    TextView current_directory = (TextView) findViewById(R.id.m_current_directory);
    current_directory.setText(m_adapter.getItem(pos).getName());
  }

  @Override
  protected void onSaveInstanceState(Bundle outState)
  {
    super.onSaveInstanceState(outState);
    TextView current_path=(TextView)findViewById(R.id.current_path);
    outState.putString(STATE_DIR, current_path.getText().toString());
    outState.putString(STATE_DIR,m_adapter.getM_root().getAbsolutePath());
  }
  
  @Override
  protected void onRestoreInstanceState(Bundle state)
  {
    super.onRestoreInstanceState(state);
    TextView current_path=(TextView)findViewById(R.id.current_path);
    current_path.setText(state.getString(STATE_DIR));
    m_adapter.addAll(new File(state.getString(STATE_ADAPTER)).listFiles()); //not sure about it

  }
  
  @Override
  public void onListItemClick(ListView l, View v, int position, long id)
  {
    File item = m_adapter.getItem(position);
    TextView current_path=(TextView)findViewById(R.id.current_path);
    current_path.setText(item.getName());
    if (item.isDirectory())
    {
      m_adapter.clear();
      m_adapter.addAll(new ArrayList(Arrays.asList(item.listFiles())));
    }
  }
  
  @Override
  public void onBackPressed()
  {
    File current = m_adapter.getM_root();

    if (current.equals(Environment.getExternalStorageDirectory()))
    {
        super.onBackPressed();
    }
    else
    {
      File parent = current.getParentFile();
      m_adapter.clear();
      m_adapter.addAll(new ArrayList(Arrays.asList(parent.listFiles())));
      TextView current_path=(TextView)findViewById(R.id.current_path);
      current_path.setText(parent.getName());
    }
}


}
