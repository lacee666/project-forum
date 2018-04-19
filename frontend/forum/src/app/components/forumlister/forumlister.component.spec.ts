import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumlisterComponent } from './forumlister.component';

describe('ForumlisterComponent', () => {
  let component: ForumlisterComponent;
  let fixture: ComponentFixture<ForumlisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumlisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumlisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
