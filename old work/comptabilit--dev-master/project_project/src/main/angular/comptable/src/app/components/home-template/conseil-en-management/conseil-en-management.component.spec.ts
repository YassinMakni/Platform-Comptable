import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConseilEnManagementComponent } from './conseil-en-management.component';

describe('ConseilEnManagementComponent', () => {
  let component: ConseilEnManagementComponent;
  let fixture: ComponentFixture<ConseilEnManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConseilEnManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConseilEnManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
