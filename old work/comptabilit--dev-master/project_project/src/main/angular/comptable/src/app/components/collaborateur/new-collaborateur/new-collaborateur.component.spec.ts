import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCollaborateurComponent } from './new-collaborateur.component';

describe('NewCollaborateurComponent', () => {
  let component: NewCollaborateurComponent;
  let fixture: ComponentFixture<NewCollaborateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewCollaborateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCollaborateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
