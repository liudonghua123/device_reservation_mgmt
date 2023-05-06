import dayjs, { Dayjs } from 'dayjs';

export const checkUsageDatetime = async (_rule: Rule, value: number) => {
  // if (!value) {
  //   return Promise.reject('Please input the datetime');
  // }
  // checkUsageDatetime value: 2023-05-06 00:20:00, type: string
  // console.info(`checkUsageDatetime value: ${value}, type: ${typeof value}`)
  if (value) {
    // check the minutes should be 10 steps and the seconds should be 0
    const date = new Date(value);
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();
    if (minutes % 10 !== 0 || seconds !== 0) {
      return Promise.reject('输入的日期时间必须是10分钟的整数倍，且秒数为0');
    }
  }
  return Promise.resolve();
};

export const extraReservationValidation = ({ usageStartDatetime, usageEndDatetime }) => {
  // 额外检测使用开始时间和结束时间，开始时间必须超过当前时间，结束时间必须大于开始时间
  const startDatetime = new Date(usageStartDatetime);
  const endDatetime = new Date(usageEndDatetime);
  const now = new Date();
  if (startDatetime < now) {
    return {
      code: 1,
      message: '使用开始时间必须大于当前时间',
    }
  }
  if (endDatetime < startDatetime) {
    return {
      code: 2,
      message: '使用结束时间必须大于开始时间',
    }
  }
  return {
    code: 0,
    message: 'OK',
  }
};


const range = (start: number, end: number) => {
  const result = [];

  for (let i = start; i < end; i++) {
    result.push(i);
  }

  return result;
};

export const disabledDate = (_: Dayjs) => {
  // Can not select days before today and today
  // return current && current < dayjs().endOf('day');
  return false;
};

const disabledHours = [...range(0, 8), ...range(22, 24)];
export const disabledTime = () => {
  const disabled = {
    disabledHours: () => disabledHours,
    disabledMinutes: () => [],
    disabledSeconds: () => [],
  };
  console.info(`disabledTime: ${JSON.stringify(disabled.disabledHours())}`);
  return disabled;
};
