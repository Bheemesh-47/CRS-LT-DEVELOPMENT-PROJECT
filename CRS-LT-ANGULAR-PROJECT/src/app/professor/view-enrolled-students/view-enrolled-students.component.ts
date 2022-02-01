/* eslint-disable no-unused-vars */
/* eslint-disable max-len */
/* eslint-disable require-jsdoc */
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Component, OnInit} from "@angular/core";
import {StudentCourseDetailsDto} from "src/Models/StudentCourseDetailsDto";


@Component({
  selector: "app-view-enrolled-students",
  templateUrl: "./view-enrolled-students.component.html",
  styleUrls: ["./view-enrolled-students.component.css"],
})
export class ViewEnrolledStudentsComponent implements OnInit {
  listOfEnrolledStudents: StudentCourseDetailsDto[] = [];
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>("http://localhost:8383/EnrolledStudents?professorId="+sessionStorage.getItem("userId")).subscribe(
        (res:StudentCourseDetailsDto[])=>{
          this.listOfEnrolledStudents=res;
        },
        (err:HttpErrorResponse)=>{
        },
    );
  }


}
