/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.lopHoc;

/**
 *
 * @author hung
 */
public class CustomTable_Lop extends AbstractTableModel{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã lớp","Tên lớp","Mã giáo viên","Mã môn","Số lượng sinh viên"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class,Integer.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<lopHoc> dsLop=new ArrayList<lopHoc>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTable_Lop(ArrayList<lopHoc> listLop)
   {
       this.dsLop=listLop;
   }
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        
        return dsLop.size();
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
            case 0: return dsLop.get(rowIndex).getMaLop();
            
            //cột c
            case 1: return dsLop.get(rowIndex).getTenLop();
            //cột kq
            case 2: return dsLop.get(rowIndex).getMaGV();
            case 3: return dsLop.get(rowIndex).getMaMon();
            case 4: return dsLop.get(rowIndex).getSoLuongSV();
        
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
