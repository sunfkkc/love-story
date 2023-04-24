import useRegister from '@/domain/auth/register/useRegister';
import React from 'react';
import { useForm } from 'react-hook-form';

const RegisterPage = () => {
  const { handleSubmit, register } = useForm();
  const { mutate } = useRegister();
  const onSubmit = (data) => {
    if (!data.name) return alert('이름 채워라');
    mutate(data);
  };
  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <h2>회원가입 고고</h2>
      <label>이름</label>
      <input {...register('name')} />
      <label>비밀번호</label>
      <input {...register('pwd')} />
      <input type="submit" />
    </form>
  );
};

export default RegisterPage;
