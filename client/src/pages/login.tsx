import { useGoogleLogin } from '@/hooks/login/useGoogleLogin';
import React from 'react';

const LoginPage = () => {
  const { mutate, data } = useGoogleLogin();
  console.log(data);
  return <button onClick={() => mutate()}>구글 로그인</button>;
};

export default LoginPage;
