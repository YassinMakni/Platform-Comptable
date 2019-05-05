import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileCollaborateurComponent } from './profile-collaborateur.component';

describe('ProfileCollaborateurComponent', () => {
  let component: ProfileCollaborateurComponent;
  let fixture: ComponentFixture<ProfileCollaborateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileCollaborateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileCollaborateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
