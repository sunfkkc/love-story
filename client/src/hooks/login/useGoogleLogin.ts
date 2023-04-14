import { client } from '@/client';
import { useMutation } from 'react-query';

const googleLogin = async () => {
  const { data } = await client.get('/oauth2/authorization/google');
  return data;
};

export const useGoogleLogin = () => {
  const { mutate, data } = useMutation(googleLogin);
  return { mutate, data };
};
