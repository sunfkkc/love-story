import { useRouter } from 'next/router';
import { useMutation } from 'react-query';

const { default: client } = require('@/client');

const register = async (body) => {
  const { data } = await client.post('/api/v1/auth/register', body);
  return data;
};

export default () => {
  const router = useRouter();
  const methods = useMutation(register, {
    onError: (err) => alert(err.response.data.message),
    onSuccess: () => {
      alert('회원가입 성공 ');
      router.push('/');
    },
  });
  return methods;
};
