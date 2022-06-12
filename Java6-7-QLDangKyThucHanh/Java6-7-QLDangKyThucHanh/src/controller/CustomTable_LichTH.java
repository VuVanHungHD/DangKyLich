/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.lichThucHanh;

/**
 *
 * @author hung
 */
public class CustomTable_LichTH extends AbstractTableModel{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã đăng ký","Nhóm","Mã lớp","Tuần","Thứ","Mã phòng","Ca"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={Integer.class,String.class,String.class,Integer.class,Integer.class,String.class,Integer.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<lichThucHanh> dsLich=new ArrayList<lichThucHanh>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTable_LichTH(ArrayList<lichThucHanh> listDK)
   {
       this.dsLich=listDK;
   }
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        
        return dsLich.size();
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
            case 0: return dsLich.get(rowIndex).getMaDK();
            case 1: return dsLich.get(rowIndex).getNhom();
            case 2: return dsLich.get(rowIndex).getMaLop();
            case 3: return dsLich.get(rowIndex).getTuan();
            case 4: return dsLich.get(rowIndex).getThu();
            case 5: return dsLich.get(rowIndex).getMaPhong();
            case 6: return dsLich.get(rowIndex).getCa();
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
