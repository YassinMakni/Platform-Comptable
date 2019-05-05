import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssistanceJuridiqueComponent } from './assistance-juridique.component';

describe('AssistanceJuridiqueComponent', () => {
  let component: AssistanceJuridiqueComponent;
  let fixture: ComponentFixture<AssistanceJuridiqueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssistanceJuridiqueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssistanceJuridiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
