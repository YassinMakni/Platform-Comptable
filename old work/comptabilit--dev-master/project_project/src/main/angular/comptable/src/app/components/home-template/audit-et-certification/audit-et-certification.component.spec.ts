import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditEtCertificationComponent } from './audit-et-certification.component';

describe('AuditEtCertificationComponent', () => {
  let component: AuditEtCertificationComponent;
  let fixture: ComponentFixture<AuditEtCertificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuditEtCertificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuditEtCertificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
