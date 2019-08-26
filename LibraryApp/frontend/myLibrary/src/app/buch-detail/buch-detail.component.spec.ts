import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuchDetailComponent } from './buch-detail.component';

describe('BuchDetailComponent', () => {
  let component: BuchDetailComponent;
  let fixture: ComponentFixture<BuchDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuchDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuchDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
