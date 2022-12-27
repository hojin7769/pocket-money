import { useGlobalStore } from '../store/global';
export const msg = {
  alert: opt => {
    const global = useGlobalStore();
    return global.$ui
      .dialog({
        title: opt.title,
        message: opt.message,
      })
      .onOk(() => {
        if (opt.onOk != null) {
          opt.onOk();
        }
      })
      .onCancel(() => {
        if (opt.onCancel != null) {
          opt.onCancel();
        }
      })
      .onDismiss(() => {
        if (opt.onDismiss != null) {
          opt.onDismiss();
        }
      });
  },
  confirm: opt => {
    const global = useGlobalStore();
    return global.$ui
      .dialog({
        title: opt.title,
        message: opt.message,
        cancel: true,
        persistent: true,
      })
      .onOk(() => {
        if (opt.onOk != null) {
          opt.onOk();
        }
      })
      .onCancel(() => {
        if (opt.onCancel != null) {
          opt.onCancel();
        }
      })
      .onDismiss(() => {
        if (opt.onDismiss != null) {
          opt.onDismiss();
        }
      });
  },
  prompt: opt => {
    const global = useGlobalStore();
    return global.$ui
      .dialog({
        title: opt.title,
        message: opt.message,
        prompt: {
          model: opt.model,
          type: opt.type, // optional
        },
        cancel: true,
        persistent: true,
      })
      .onOk(data => {
        if (opt.onOk != null) {
          opt.onOk(data);
        }
      })
      .onCancel(() => {
        if (opt.onCancel != null) {
          opt.onCancel();
        }
      })
      .onDismiss(() => {
        if (opt.onDismiss != null) {
          opt.onDismiss();
        }
      });
  },
};
