import { registerPlugin } from '@capacitor/core';

import type { MapsPlugin } from './definitions';

const Maps = registerPlugin<MapsPlugin>('Maps', {
  web: () => import('./web').then(m => new m.MapsWeb()),
});

export * from './definitions';
export { Maps };
