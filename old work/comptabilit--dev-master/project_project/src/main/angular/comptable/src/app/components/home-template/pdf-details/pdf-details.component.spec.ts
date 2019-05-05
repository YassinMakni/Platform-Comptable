import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PdfDetailsComponent } from './pdf-details.component';

describe('PdfDetailsComponent', () => {
  let component: PdfDetailsComponent;
  let fixture: ComponentFixture<PdfDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PdfDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PdfDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
