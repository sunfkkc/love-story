import { useRouter } from 'next/router';
import { useMutation } from 'react-query';
import forge from 'node-forge';
const { default: client } = require('@/client');

const register = async (body) => {
  const { data } = await client.post('/api/v1/auth/register', body);
  return data;
};

export default () => {
  const router = useRouter();
  const methods = useMutation(register, {
    onError: (err) => alert(err.response.data.message),
    onSuccess: (data) => {
      alert('회원가입 성공 ');
      router.push('/');
      localStorage.setItem('user', encrypt(data.name));
    },
  });
  return methods;
};

const encrypt = (name) => {
  const key = forge.util.hexToBytes(process.env.NEXT_PUBLIC_ENCRYPT_KEY);

  const cipher = forge.cipher.createCipher('AES-CBC', key);
  const iv = forge.random.getBytesSync(16); // 초기화 벡터(IV) 생성
  cipher.start({ iv });
  cipher.update(forge.util.createBuffer(name));
  cipher.finish();
  return cipher.output.getBytes();
};
