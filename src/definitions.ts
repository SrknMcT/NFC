export interface ReadCardByNFCPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
