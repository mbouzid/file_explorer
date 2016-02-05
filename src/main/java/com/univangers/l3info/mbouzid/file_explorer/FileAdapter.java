package com.univangers.l3info.mbouzid.fileexplorer;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;

public class FileExplorer extends ArrayAdapter<File>
{

  File m_root ;
  
  public FileAdapter(Context context, File root)
  {
     super(context, R.layout.line,new ArrayList<File>(Arrays.asList(root.listFiles())));
     m_root=root;
  }
  
  public View getView(int position, View v, ViewGroup parent)
  {
    if (v == null)
    {
      LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      v = inflater.inflate(R.layout.line,parent,false);
      
    }
    File item = getItem(position);
    ImageView img = (ImageView)v.findViewById(R.id.icon_image);
    
    if (item.isDirectory())
    {
      img.setImageResource(R.drawable.directory_icon);
    }
    else
    {
      img.setImageResource(R.drawable.blank_file_icon);
    }
      
    TextView current_directory=(TextView)v.findViewById(R.id.path_name);
    current_directory.setText(getItem(position).getName());
    
    return v;
 }


}
