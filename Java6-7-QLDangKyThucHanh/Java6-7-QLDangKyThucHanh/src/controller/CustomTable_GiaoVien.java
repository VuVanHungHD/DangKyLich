/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.GV;

/**
 *
 * @author hung
 */
public class CustomTable_GiaoVien extends AbstractTableModel{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã giáo viên","Tên giáo viên","mật khẩu"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<GV> dsGV=new ArrayList<GV>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTable_GiaoVien(ArrayList<GV> listGV)
   {
       this.dsGV=listGV;
   }
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        
        return dsGV.size();
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
            case 0: return dsGV.get(rowIndex).getMaGV();
            
            //cột c
            case 1: return dsGV.get(rowIndex).getTenGV();
            //cột kq
            case 2: return dsGV.get(rowIndex).getMatKhau();
        
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
