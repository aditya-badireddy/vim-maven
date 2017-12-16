import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VimComponent } from './vim.component';

describe('VimComponent', () => {
  let component: VimComponent;
  let fixture: ComponentFixture<VimComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VimComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
