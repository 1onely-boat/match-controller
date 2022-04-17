package com.competition.controller;

import com.competition.entities.Teacher;
import com.competition.entities.WorkList;
import com.competition.service.WorkService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;



//用于导出excel表格
@Controller
public class ExcelController {

    @Autowired
    WorkService workService;

    @GetMapping("/write")
    public void downloadAllClassmate(HttpServletResponse response, HttpSession session) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        WorkList workList = new WorkList();
        Teacher teacher = (Teacher) session.getAttribute("loginUser");
        workList.setTeacherName(teacher.getTeacherName());
        List<WorkList> list = workService.getLists(workList);


        String fileName = teacher.getTeacherWork() + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = {"参与比赛名称", "参与队伍名称", "比赛级别", "工作量"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (WorkList workList1 : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(workList1.getRaceName());
            row1.createCell(1).setCellValue(workList1.getTeamName());
            row1.createCell(2).setCellValue(workList1.getRaceLevel());
            if (workList1.getRaceLevel() == 1) {
                row1.createCell(3).setCellValue("0.8");
            }
            if (workList1.getRaceLevel() > 1) {
                row1.createCell(3).setCellValue("1");
            }
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @GetMapping("/writeAll")
    public void downloadAll(HttpServletResponse response, HttpSession session) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        WorkList workList = new WorkList();
        Teacher teacher = (Teacher) session.getAttribute("loginUser");

        List<WorkList> list = workService.getLists(workList);


        String fileName = teacher.getTeacherWork() + "ruanjianxueyuan.xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = {"导师姓名", "比赛名称", "队伍名称", "比赛级别", "工作量"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (WorkList workList1 : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(workList1.getTeacherName());
            row1.createCell(1).setCellValue(workList1.getRaceName());
            row1.createCell(2).setCellValue(workList1.getTeamName());
            row1.createCell(3).setCellValue(workList1.getRaceLevel());
            if (workList1.getRaceLevel() == 1) {
                row1.createCell(4).setCellValue("0.8");
            }
            if (workList1.getRaceLevel() > 1) {
                row1.createCell(4).setCellValue("1");
            }
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @GetMapping("/writeTeacher/{teacherName}")
    public void downloadTeacher(HttpServletResponse response, HttpSession session, @PathVariable("teacherName") String teacherName) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        WorkList workList = new WorkList();
        workList.setTeacherName(teacherName);
        List<WorkList> list = workService.getLists(workList);


        String fileName = teacherName + "_ruanjianxueyuan.xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = {"导师姓名", "参与比赛名称", "参与队伍名称", "比赛级别", "工作量"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (WorkList workList1 : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(workList1.getTeacherName());
            row1.createCell(1).setCellValue(workList1.getRaceName());
            row1.createCell(2).setCellValue(workList1.getTeamName());
            row1.createCell(3).setCellValue(workList1.getRaceLevel());
            if (workList1.getRaceLevel() == 1) {
                row1.createCell(4).setCellValue("0.8");
            }
            if (workList1.getRaceLevel() > 1) {
                row1.createCell(4).setCellValue("1");
            }
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

}