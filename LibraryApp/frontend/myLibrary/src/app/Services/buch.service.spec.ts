import { TestBed } from '@angular/core/testing';

import { BuchService } from './buch.service';

describe('BuchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BuchService = TestBed.get(BuchService);
    expect(service).toBeTruthy();
  });
});
