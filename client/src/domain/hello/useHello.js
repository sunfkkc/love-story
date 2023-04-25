import { useMutation } from 'react-query';

const { default: client } = require('@/client');

const hello = async () => {
  await client.post('/api/v1/hello');
};

export default () => {
  const methods = useMutation(hello);
  return methods;
};
