import { WebPlugin } from '@capacitor/core';

import type { MapsPlugin } from './definitions';

export class MapsWeb extends WebPlugin implements MapsPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
