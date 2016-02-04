package com.univangers.l3info.mbouzid.fileexplorer;

import android.content.Context;
import android.widget.ArrayAdapter;
import java.io.File;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class FileExplorer extends ArrayAdapter<File>
{

  public FileAdapter(Context context, File [] objects)
  {
     super(context, R.layout.ligne, objects);
  }
  
  public View getView(int position, View v, ViewGroup parent)
  {
    if (v == null)
    {
      LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      v = inflater.inflate(R.layout.line,parent,false);
      TextView cdir=(TextView)v.findViewById(R.id.m_directory);
      cdir.setText(getItem(position).getName());
    }
    return v;
 }


}
