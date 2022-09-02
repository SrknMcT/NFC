import { WebPlugin } from '@capacitor/core';

import type { ReadCardByNFCPlugin } from './definitions';

export class ReadCardByNFCWeb extends WebPlugin implements ReadCardByNFCPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
