/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.monHoc;


/**
 *
 * @author hung
 */
public class CustomTable_MonHoc extends AbstractTableModel{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã lớp","Tên lớp","Số TC"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,Integer.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<monHoc> dsMon=new ArrayList<monHoc>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTable_MonHoc(ArrayList<monHoc> listMon)
   {
       this.dsMon=listMon;
   }
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        
        return dsMon.size();
    }
    //Lấy số lượng tiêu để của mảng.
    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            
            //Cột số a
           // case 0: return dsThiSinh.get(rowIndex).getHoTen();
            //Cột b
            case 0: return dsMon.get(rowIndex).getMaMon();
            
            //cột c
            case 1: return dsMon.get(rowIndex).getTenMon();
            //cột kq
            case 2: return dsMon.get(rowIndex).getSoTC();
        
            default :return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }
}
