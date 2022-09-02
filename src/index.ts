import { registerPlugin } from '@capacitor/core';

import type { ReadCardByNFCPlugin } from './definitions';

const ReadCardByNFC = registerPlugin<ReadCardByNFCPlugin>('ReadCardByNFC', {
  web: () => import('./web').then(m => new m.ReadCardByNFCWeb()),
});

export * from './definitions';
export { ReadCardByNFC };
