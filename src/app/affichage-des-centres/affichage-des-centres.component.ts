import { outputAst } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';

@Component({
  selector: 'app-affichage-des-centres',
  templateUrl: './affichage-des-centres.component.html',
  styleUrls: ['./affichage-des-centres.component.css']
})

export class AffichageDesCentresComponent implements OnInit {
 
  @Input() center?: covid; 

  @Output() selected = new EventEmitter<covid>();

  aclient: client = {
    id: 3,
    name: "Dupont",
    prenom: "Jules",
    email: "DupontJules@gmail.com",
    Date: new Date()
  };

  constructor() { }

  ngOnInit(): void {
  }

  choisir(){ 
    this.selected.emit(this.center);
  }

}
