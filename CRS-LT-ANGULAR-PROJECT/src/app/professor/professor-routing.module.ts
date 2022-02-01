/* eslint-disable max-len */
/* eslint-disable require-jsdoc */
/* eslint-disable new-cap */
import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import { AddGradesComponent } from "./add-grades/add-grades.component";
import {ProfessorComponent} from "./professor.component";
import {ProfessorGuard} from "./professor.guard";
import {ViewEnrolledStudentsComponent} from "./view-enrolled-students/view-enrolled-students.component";

const routes: Routes = [{path: "", component: ProfessorComponent, canActivate: [ProfessorGuard],
  children: [
    {path: "enrolled-student", component: ViewEnrolledStudentsComponent},
    {path:"add-grades",component:AddGradesComponent}
  ],


},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfessorRoutingModule { }
