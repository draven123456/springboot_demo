package com.draven.demo.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/** 
 * 共分为六部完成根据模板导出excel操作：<br/> 
 * 第一步、设置excel模板路径（setSrcPath）<br/> 
 * 第二步、设置要生成excel文件路径（setDesPath）<br/> 
 * 第三步、设置模板中哪个Sheet列（setSheetName）<br/> 
 * 第四步、获取所读取excel模板的对象（getSheet）<br/> 
 * 第五步、设置数据（分为6种类型数据：setCellStrValue、setCellDateValue、setCellDoubleValue、setCellBoole、setCellCalendarValue、setCellRichTextStrValue）<br/> 
 * 第六步、完成导出 （exportToNewFile）<br/> 
 *  
 * @author Administrator 
 * 
 */  
public class ExcelUtil {  
    Workbook tempWorkBook = null;  
    Sheet tempSheet = null;  
    Row tempRow = null;  
    Cell tempCell = null;  
    
    InputStream inputstream = null;
    File file= null;
    OutputStream outputstream = null;
    //自动添加行起始点
    int num = 15;
       
    public void setStream(InputStream inputstream,OutputStream outputstream){
        this.inputstream = inputstream;
        this.outputstream = outputstream;
    }
    
    public void setUrl(String intString,String outString){
        File file= null;
        try {
            file = new File(outString); 
            if(!file.exists()){

                file.createNewFile();

                }
            this.outputstream = new FileOutputStream(file); 
            this.inputstream = new FileInputStream(intString);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void createExcel() {  
            try {  
                // 获取模板  
                tempWorkBook = new XSSFWorkbook(inputstream);  
                // 获取模板sheet页  
                tempSheet = tempWorkBook.getSheetAt(0);  
                // 将数据写入excel  
                // 创建单元格样式对象   
                XSSFCellStyle xssfCellStyle = cellStyle();
                setCellEd(1,0,"niubb",xssfCellStyle);
                setCellEd(3, 1, "zhongguo", xssfCellStyle);

                int len = 6;
                for(int i=0;i<len;i++){
                    
                    setCell(num+i,0,"i="+i,xssfCellStyle);
                    setCellEd(num+i,1,"i="+i,xssfCellStyle);
                    setCellEd(num+i,2,"i="+i,xssfCellStyle);
                    setCellEd(num+i,3,"i="+i,xssfCellStyle);
                    setCellEd(num+i,4,"i="+i,xssfCellStyle);
                    setCellEd(num+i,5,"i="+i,xssfCellStyle);

                }
                //在sheet里增加合并单元格  
                cellRangStyle(num+len+1,num+len+1,0,1);
                setCell(num+len+1,0,"Subtotal 小计",xssfCellStyle);
                setCellEd(num+len+1,1,"-",xssfCellStyle);
                setCellEd(num+len+1,2,"-",xssfCellStyle);
                setCellEd(num+len+1,3,"-",xssfCellStyle);
                setCellEd(num+len+1,4,"-",xssfCellStyle);
                setCellEd(num+len+1,5,"55",xssfCellStyle);
                //在sheet里增加合并单元格 
                cellRangStyle(num+len+2,num+len+2,0,1);
                setCell(num+len+2,0,"Discount 折扣",xssfCellStyle);
                setCellEd(num+len+2,1,"-",xssfCellStyle);
                setCellEd(num+len+2,2,"-",xssfCellStyle);
                setCellEd(num+len+2,3,"-",xssfCellStyle);
                setCellEd(num+len+2,4,"-",xssfCellStyle);
                setCellEd(num+len+2,5,"-",xssfCellStyle);
                //在sheet里增加合并单元格
                cellRangStyle(num+len+3,num+len+3,0,1);
                setCell(num+len+3,0,"OtherExpenses其他费用",xssfCellStyle);
                setCellEd(num+len+3,1,"-",xssfCellStyle);
                setCellEd(num+len+3,2,"-",xssfCellStyle);
                setCellEd(num+len+3,3,"-",xssfCellStyle);
                setCellEd(num+len+3,4,"-",xssfCellStyle);
                setCellEd(num+len+3,5,"-",xssfCellStyle);
                //在sheet里增加合并单元格 
                cellRangStyle(num+len+4,num+len+4,0,1);
                setCell(num+len+4,0,"Total合计",xssfCellStyle);
                setCellEd(num+len+4,1,"-",xssfCellStyle);
                setCellEd(num+len+4,2,"-",xssfCellStyle);
                setCellEd(num+len+4,3,"-",xssfCellStyle);
                setCellEd(num+len+4,4,"-",xssfCellStyle);
                setCellEd(num+len+4,5,"-",xssfCellStyle);
                //在sheet里增加合并单元格 
                cellRangStyle(num+len+5,num+len+6,0,0);
                cellRangStyle(num+len+5,num+len+6,1,5);
                setCell(num+len+5,0,"REMARKS备注",xssfCellStyle);
                setCellEd(num+len+5,1,"25555555555555555555555555555555555555555555555555555555",xssfCellStyle);

                // 将内容写入Excel  
                tempWorkBook.write(outputstream);  
            } catch (Exception e) {  
                e.printStackTrace();  
            } finally {  
                
            }  
      
        }  
    public XSSFCellStyle cellStyle(){
        // 创建单元格样式对象   
        XSSFCellStyle alignStyle = (XSSFCellStyle)tempWorkBook.createCellStyle();   
        alignStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);   
        alignStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        alignStyle.setBorderBottom(CellStyle.BORDER_THIN);   
        alignStyle.setBorderTop(CellStyle.BORDER_THIN);   
        alignStyle.setBorderLeft(CellStyle.BORDER_THIN);   
        alignStyle.setBorderRight(CellStyle.BORDER_THIN); 
        return alignStyle;
    }
    
    public void setCell(int num1,int num2,String str,XSSFCellStyle alignStyle){
        tempRow = tempSheet.createRow(num1); 
        tempCell = tempRow.createCell(num2);  
        tempCell.setCellValue(str);
        tempCell.setCellStyle(alignStyle); 
    }
    public void setCellEd(int num1,int num2,String str,XSSFCellStyle alignStyle){
        tempRow = tempSheet.getRow(num1); 
        tempCell = tempRow.createCell(num2);  
        tempCell.setCellValue(str);
        tempCell.setCellStyle(alignStyle); 
    }
    
    public void cellRangStyle(int num1,int num2,int num3,int num4){
        CellRangeAddress cra=new CellRangeAddress(num1,num2,num3,num4);
        tempSheet.addMergedRegion(cra);  
        // 使用RegionUtil类为合并后的单元格添加边框  
        RegionUtil.setBorderBottom(1, cra, tempSheet,tempWorkBook); // 下边框  
        RegionUtil.setBorderLeft(1, cra, tempSheet,tempWorkBook); // 左边框  
        RegionUtil.setBorderRight(1, cra, tempSheet,tempWorkBook); // 有边框  
        RegionUtil.setBorderTop(1, cra, tempSheet,tempWorkBook); // 上边框 
    }
}