export interface ReadCardByNFCPlugin {
  readCard(options: { value: string }): Promise<{ cardstatus: string }>;
}
