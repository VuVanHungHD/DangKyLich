/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.phongHoc;

/**
 *
 * @author hung
 */
public class CustomTable_Phong extends AbstractTableModel{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã phòng","Tên phòng","Hệ điều hành","Ram","CPU","Số máy"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,
        String.class,String.class,Integer.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<phongHoc> dsPhong=new ArrayList<phongHoc>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTable_Phong(ArrayList<phongHoc> listPhong)
   {
       this.dsPhong=listPhong;
   }
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        
        return dsPhong.size();
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
            case 0: return dsPhong.get(rowIndex).getMaPhong();
            
            //cột c
            case 1: return dsPhong.get(rowIndex).getTenPhong();
            //cột kq
            case 2: return dsPhong.get(rowIndex).getHDH();
            case 3: return dsPhong.get(rowIndex).getRam();
            case 4: return dsPhong.get(rowIndex).getCPU();
            case 5: return dsPhong.get(rowIndex).getSoMay();
            
        
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
