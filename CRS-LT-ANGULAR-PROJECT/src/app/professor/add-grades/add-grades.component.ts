import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Component, OnInit} from "@angular/core";
import {FormBuilder, Validators} from "@angular/forms";
import {StudentCourseDetailsDto} from "src/Models/StudentCourseDetailsDto";
import {StudentGrade} from "src/Models/StudentGrade";
@Component({
  selector: 'app-add-grades',
  templateUrl: './add-grades.component.html',
  styleUrls: ['./add-grades.component.css']
})
export class AddGradesComponent implements OnInit {

  listOfEnrolledStudents: StudentCourseDetailsDto[] = [];
  gradeAddedMessage:string="NA";
  gradeAddedIndex:number=-1;
  studentGrade!: StudentGrade;
  markForm = this.fb.group({
    mark: ["", [Validators.required]]});
  constructor(private http:HttpClient, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.http.get<any>("http://localhost:8383/EnrolledStudents?professorId="+sessionStorage.getItem("userId")).subscribe(
        (res:StudentCourseDetailsDto[])=>{
          this.listOfEnrolledStudents=res;
        },
        (err:HttpErrorResponse)=>{
        },
    );
  }

  addGrade(i:number) {
    this.gradeAddedIndex=i;
    this.gradeAddedMessage="";
  }
  submitGrade(i:number) {
    let grade:any;
    if (this.markForm.value["mark"]>=0 && this.markForm.value["mark"]<50) {
      grade="FAIL";
    } else if (this.markForm.value["mark"]>=50 && this.markForm.value["mark"]<60) {
      grade="E";
    } else if (this.markForm.value["mark"]>=60 && this.markForm.value["mark"]<70) {
      grade="D";
    } else if (this.markForm.value["mark"]>=70 && this.markForm.value["mark"]<80) {
      grade="C";
    } else if (this.markForm.value["mark"]>=80 && this.markForm.value["mark"]<90) {
      grade="B";
    } else if (this.markForm.value["mark"]>=90 && this.markForm.value["mark"]<=100) {
      grade="A";
    }

    const id1:any=sessionStorage.getItem("userId");
    const id2=+id1;
    this.studentGrade=new StudentGrade(this.listOfEnrolledStudents[i].studentId, this.listOfEnrolledStudents[i].courseId, id2, this.markForm.value["mark"], grade);
    const body=JSON.stringify(this.studentGrade);
    const headers={"Content-Type": "application/json"};
    console.log(body);

    this.http.post<any>("http://localhost:8383/grade", body, {headers}).subscribe(

        (res:string)=>{
          this.gradeAddedMessage="Grade Added Sucessfully";
          this.markForm.reset();
        },
        (err:HttpErrorResponse)=>{
          if (err.error.message) {
            this.gradeAddedMessage=err.error.message;
            this.markForm.reset();
          } else {
            this.gradeAddedMessage="Grade Added Sucessfully";
            this.markForm.reset();
          }
        },
    );
  }
  cancelAddGrade() {
    this.gradeAddedIndex=-1;
    this.markForm.reset();
  }
}
