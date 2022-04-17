package com.competition;

import com.competition.entities.*;
import com.competition.mapper.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring_Application_startTests {

    @Autowired
    TeacherMapper teacherMapper;
    //测试教师
    @Test
    public void teacherTest(){

        Teacher teacherById = teacherMapper.getTeacherById(1);
        System.out.println("uuu "+teacherById.getTeacherName());
        Teacher teacherByTeacherNumber = teacherMapper.getTeacherByTeacherNumber("123");
        System.out.println(teacherByTeacherNumber.getTeacherName());
        System.out.println(teacherByTeacherNumber.getTeacherNumber());

      for(int i=1;i<3;i++){
       Teacher teacher = new Teacher();

       teacher.setTeacherNumber(130+i);
       teacher.setTeacherPassword("123456");
       if(i%2==0){
           teacher.setTeacherName("小红"+i+"号");
       teacher.setTeacherProfession("副教授");
       teacher.setTeacherSex("女");
       }else{
           teacher.setTeacherName("小张"+i+"号");
           teacher.setTeacherProfession("教授");
           teacher.setTeacherSex("男");
       }
       teacher.setTeacherMobile("13536362850");

       teacherMapper.addTeacher(teacher);
    }

   //修改测试
   Teacher t = new Teacher();
   t.setTeacherSex("女");
   teacherMapper.updateTeacher(t);
       List<Teacher> lists = teacherMapper.getLists(t);
        for (Teacher bs : lists) {
            System.out.println(bs.getTeacherName() + "--" + bs.getTeacherProfession());
        }
    }

    @Autowired
    StudentMapper studentMapper;
    //测试学生
    @Test
    public void studentTest(){
       // Student studentById = studentMapper.getStudentById(2);
        //System.out.println(studentById.getStudentName());
        Student student = new Student();
        for (int i=1;i<25;i++){
            if(i%2 == 0){
            student.setStudentName("张一鸣"+i);
            student.setStudentClass("卓越161");
            student.setStudentMobile("13526263852");
            student.setStudentNumber("201607104225");
            student.setStudentSex("男");
            student.setStudentWechar("13526263852wx");
            }else{
                student.setStudentName("时云凤"+i);
                student.setStudentClass("卓越162");
                student.setStudentMobile("13939263878");
                student.setStudentNumber("20160710422"+i);
                student.setStudentSex("女");
                student.setStudentWechar("13939263878wx");
            }
            studentMapper.addStudent(student);
        }
        Student ss=new Student();
        List<Student> lists = studentMapper.getLists(ss);
        for (Student bs : lists) {
            System.out.println(bs.getStudentName() + "----" + bs.getStudentNumber());
        }
    }

    @Autowired
    RaceMapper raceMapper;
    @Test
    public void raceTest(){
        Race race = new Race();
        List<Race> lists = raceMapper.getLists(race);
        for (Race bs : lists) {
            System.out.println(bs.getRaceName() + "----" + bs.getRaceLevel());
        }
        Race raceById = raceMapper.getRaceById(1);
        System.out.println("getRaceById-> "+raceById.getRaceName());
        Race race1 = new Race();
        race1.setRaceName("数据库查询比赛");
        race1.setRaceLevel(1);
        race1.setRaceLocation("中原工学院北区");
        race1.setRaceMaster("中原工学院");
        race1.setUpdateId(1);
        raceMapper.addRace(race1);

    }

    @Autowired
    TeamMapper teamMapper;
    @Test
    public void teamTest(){
        TeamList teamList = new TeamList();
        List<TeamList> lists = teamMapper.getLists(teamList);
        for (TeamList bs : lists) {
            System.out.println(bs);
            System.out.println(bs.getTeamStatus() + "----" +bs.getTeamName() + "----" +bs.getRaceName() + "----" + bs.getStudentName()+ "----" + bs.getRaceLevel());
        }

       /* TeamList teamById = teamMapper.getTeamById(1);
        System.out.println(teamById);
        System.out.println("--===========");
        System.out.println(teamById.toString());*/

       //通过id删除 team
      // teamMapper.deleteTeamById(3);
       /* Team teamById = teamMapper.getTeamById(1);
        System.out.println(teamById.getTeamName());
        Team team = new Team();
        team.setTeamName("微软");
        List<Team> lists = teamMapper.getLists(team);
        for (Team bs : lists) {
            System.out.println(bs.getTeamName() + "----" + bs.getProductionInfo());
        }*/

    }

    @Autowired
    FinancialMapper financialMapper;


    @Test
    public void financialTest(){
       /* FinancialList financialList = new FinancialList();
        System.out.println("haha开始测试TeamList");
        List<FinancialList> lists = financialMapper.getLists(financialList);
        for (FinancialList bs : lists) {
            System.out.println(bs.getTeamName() + "<------>" + bs.getRaceName());
        }*/

        FinancialList financialById = financialMapper.getFinancialById(1);
        System.out.println(financialById.getTotalFee());

    }


    @Autowired
    TeacherWorkMapper teacherWorkMapper;
    @Test
    public void teacherWorkTest(){
        TeacherWork a = new TeacherWork();
        List<TeacherWork> lists = teacherWorkMapper.getLists(a);
        for(TeacherWork t :lists){
            System.out.println(t.getWid()+"--=--");
        }
        TeacherWork teacherWorkById = teacherWorkMapper.getTeacherWorkById(1);
        System.out.println(teacherWorkById.getWid()+"erw88***");

        teacherWorkById.setTeacherId(111);
        teacherWorkMapper.updateTeacherWork(teacherWorkById);

        teacherWorkMapper.deleteTeacherWorkById(2);
    }

    @Autowired
    AwardMapper awardMapper;
    @Test
    public void awardTest(){
       /* AwardList a= new AwardList();
        List<AwardList> lists = awardMapper.getLists(a);
        for(AwardList t:lists){
            System.out.println("队伍名:"+t.getTeamName()+"比赛名:"+t.getRaceName()+"第一指导老师"+t.getTeacherName());
        }
        AwardList t = awardMapper.getAwardListById(1);
        System.out.println("队伍名:"+t.getTeamName()+", 比赛名:"+t.getRaceName()+", 第一指导老师"+t.getTeacherName());
*/
        Award a = new Award();
        AwardList awardListById = awardMapper.getAwardListById(12);
        awardListById.setIfApprove(1);
        awardMapper.updateAwardList(awardListById);
    }

    @Autowired
    WorkMapper workMapper;
    @Test
    public void workTest(){

        WorkList workList = new WorkList();
        workList.setTeacherName("郭");
        List<WorkList> lists = workMapper.getLists(workList);
        for(WorkList w:lists){
            System.out.println(w.getTeacherName()+"<-->"+w.getRaceLevel()+"<-->"+w.getRaceName()+"<-->"+w.getTeamName());
        }

        WorkList workListById = workMapper.getWorkListById(2);
        System.out.println(workListById.toString());
        Work work = new Work();
        work.setRaceId(1);
        work.setTeacherId(3);
        work.setTeamId(2);
        work.setStatus(0);
        workMapper.addWork(work);

    }
    @Autowired
    PredictFinancialMapper predictFinancialMapper;
    @Test
    public void predictFinancialTest(){
        PredictFinancial p = new PredictFinancial();
      /*  p.setRoomPrice(100);
        p.setPaymentPrice(2000);
        predictFinancialMapper.addPredictFinancial(p);*/
        PredictFinancialList predictFinancialList = new PredictFinancialList();
        predictFinancialList.setTeamName("中工");
        List<PredictFinancialList> lists = predictFinancialMapper.getLists(predictFinancialList);
        for(PredictFinancialList predictFinancial :lists){
            System.out.println(predictFinancial.getPaymentPrice());
        }

    }




}
