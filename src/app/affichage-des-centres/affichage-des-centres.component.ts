import { outputAst } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';
import { centreService } from './affichage-des-centres.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { DetailCentreComponent } from '../detail-centre/detail-centre.component';
import { AnimationStyleMetadata } from '@angular/animations';

@Component({
  selector: 'app-affichage-des-centres',
  templateUrl: './affichage-des-centres.component.html',
  styleUrls: ['./affichage-des-centres.component.css']
})

export class AffichageDesCentresComponent implements OnInit {
 
  // @Input() center?: covid; 

  // @Output() selected = new EventEmitter<covid>();

  // aclient: client = {
  //   id: 3,
  //   name: "Dupont",
  //   prenom: "Jules",
  //   email: "DupontJules@gmail.com",
  //   Date: new Date()
  // };

  // constructor() { }

  // ngOnInit(): void {
  // }

  // choisir(){ 
  //   this.selected.emit(this.center);
  // }

  public errMsg: string | undefined;
  searchKey:string= " ";

  constructor(private centreService: centreService,
    private dialog: MatDialog) { }

  listeCentres: covid[] = [];
  FilteredCenters: covid[] = []

  ngOnInit() {
    this.centreService.getCentres().subscribe(
      (listeCentres : covid []) => {
        this.listeCentres = listeCentres;
      },

      //error: err => this.errMsg = err
    );

    // this.centreService.getCentresByName(this.searchKey).subscribe(
    //   (FilteredCenters : covid []) => {
    //     this.FilteredCenters = FilteredCenters;
    //   },

    //   //error: err => this.errMsg = err
    // );
  }

  onCreate(){
    this.centreService.initializeFormGroup();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "50%";
    dialogConfig.panelClass = 'bg-color'
    this.dialog.open(DetailCentreComponent,dialogConfig);
  }

  onEdit(element:any){
    this.centreService.populateForm(element);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "50%";
    dialogConfig.panelClass = 'bg-color'
    this.dialog.open(DetailCentreComponent,dialogConfig);
  }

}
